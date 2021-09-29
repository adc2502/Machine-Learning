# Andreas Campbell
# Newcastle University

import pandas as pd
import matplotlib.pyplot as plt

df = pd.read_pickle('data_files/Perfectly_Balanced_100k.pkl')

# assigns a value for each category
df['category_id'] = df['categories'].factorize()[0]
category_id_df = df[['categories', 'category_id']].drop_duplicates().sort_values('category_id')
category_to_id = dict(category_id_df.values)
id_to_category = dict(category_id_df[['category_id', 'categories']].values)

print(df)

print(df.categories.value_counts())
print(df.category_id.value_counts())


print("Total is: ", df['category_id'].count())


# plots bar chart with number of records per category
fig = plt.figure(figsize=(8,6))
df.groupby('categories').categories.count().plot.bar(ylim=0)
plt.show()


