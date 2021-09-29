# Andreas Campbell
# Newcastle University

import pandas as pd
import gzip
import re
import string

# read in dataframe and removes some columns
df = pd.read_pickle('data_files/df_amazon.pkl')
print(df.columns)
exit()
df.drop(df.columns[[0, 1, 2, 5, 6, 7, 8]], axis = 1, inplace = True)

print(df.columns)
print(df.head)


def clean_title_round1(text):
    # make description lowercase, remove punctiation and numbers
    text = re.sub('\w*\d\w*', '', text)
    text = re.sub('\[.*?\]', '', text)
    text = re.sub('[%s]' % re.escape(string.punctuation), '', text)
    text = text.lower()

    return text


round1 = lambda x: clean_title_round1(x)


def clean_title_round2(text):
    #Get rid of some additional punctuation and non-sensical text that was missed the first time around
    text = re.sub('[‘’“”…]', '', text)
    text = re.sub('\n', '', text)
    return text


round2 = lambda x: clean_title_round2(x)


def remove_duplicates():
    # removes duplicate values
    print("Title Count Before: ", df['title'].count())
    df.drop_duplicates(subset ="title", keep = False, inplace = True)
    print("Title Count After: ", df['title'].count())

#mght break
def remove_brackets():
    # removes brackets from the breadcrumb field
    df['categories'] = pd.DataFrame([str(line).strip('[').strip(']').replace("'","") for line in df['categories']])


def one_category(text):
    # removes all but the first breadcrumb
    sub_str = ","
    try:
        text = text[:text.index(sub_str) + (len(sub_str) - 1)]
    except:
        pass
    return text

round3 = lambda x: one_category(x)


def remove_null(df):
    # removes null data
    df = df[df['categories'].notna()]
    df = df[df['title'].notna()]
    return df


#---------------------------------------------------
# runs all the functions

df = remove_null(df)

title_clean = pd.DataFrame(df.title.apply(round1))

df['title'] = pd.DataFrame(title_clean.title.apply(round2))

#remove_duplicates()

remove_brackets()

df['categories'] = pd.DataFrame(df.categories.apply(round3))

df = remove_null(df)

# save cleaned data
df.to_pickle("data_files/FD_completely_clean_with_duplicates.pkl")

print(df.head)
