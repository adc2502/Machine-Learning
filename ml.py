# Andreas Campbell
# Newcastle University

import pandas as pd
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.utils import shuffle
import matplotlib.pyplot as plt
from sklearn.model_selection import train_test_split
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.feature_extraction.text import TfidfTransformer
from sklearn.naive_bayes import MultinomialNB

# imports the data
df = pd.read_pickle('Data Preparation/data_files/Perfectly_Balanced_10k.pkl')

# gives each category a numeric value
df['category_id'] = df['categories'].factorize()[0]
category_id_df = df[['categories', 'category_id']].drop_duplicates().sort_values('category_id')
category_to_id = dict(category_id_df.values)
id_to_category = dict(category_id_df[['category_id', 'categories']].values)

# removes useless words and converts words to a value
tfidf = TfidfVectorizer(sublinear_tf=True, min_df=5, norm='l2',
                        encoding='latin-1', ngram_range=(1, 2), stop_words='english')

# calculates features of each category to help the prediction module
features = tfidf.fit_transform(df.title).toarray()
labels = df.category_id
print(features.shape)
print(df.categories.value_counts())

df = shuffle(df)
print(df)

N = 2

# train the dataset using the features and use the multinomial naive bayes model
X_train, X_test, y_train, y_test = train_test_split(df['title'], df['categories'], random_state=0)
count_vect = CountVectorizer()
X_train_counts = count_vect.fit_transform(X_train)
tfidf_transformer = TfidfTransformer()
X_train_tfidf = tfidf_transformer.fit_transform(X_train_counts)
clf = MultinomialNB().fit(X_train_tfidf, y_train)

# read in the transaction data
column_names = ["entry", "price"]
df_entry = pd.read_csv("JavaOut.csv", names=column_names)
print(df_entry)

# read csv file as a list of lists

# create new datframe with transaction data
columns = ["entries", "prediction", "Spending"]
df_predic = pd.DataFrame(columns=columns)
print(df_predic)

entries = df_entry.entry.to_list()
prices = df_entry.price.to_list()

# assign their prediction value
df_predic["entries"] = entries
df_predic['prediction'] = clf.predict(count_vect.transform(entries))
df_predic['Spending'] = prices

print("/////////////")
print(df_predic)
print("/////////////")

# count the amount spent on each prediction
result = df_predic.groupby('prediction').sum()

print(result)

# plot the pie chart
result.plot.pie(title='Percentage Spent Per Category', subplots=True, figsize=(15, 12), autopct='%1.1f%%',
                pctdistance=1.1, labeldistance=1.2)

# save pie chart
plt.savefig('result.png')
plt.show()
