# Andreas Campbell
# Newcastle University

import pandas as pd
import matplotlib.pyplot as plt

df = pd.read_pickle('data_files/FD_completely_clean_with_duplicates_andID.pkl')

# categories to balance
array = [0, 2, 3, 13, 9, 5, 4, 11, 17, 7, 10, 16, 22, 1]
sample_size = 10000

major_df = df.loc[df['category_id'] == 0]

# calculate ratio to get 10k records
frac = sample_size/(major_df.count().values[0])

print("Fraction: ", frac)

balanced_df = major_df.sample(frac=frac, replace=True)


for x in array[1:]:
    # uses the ratio to undersample or oversample the data
    major_df = df.loc[df['category_id'] == x]

    frac = sample_size/(major_df.count().values[0])

    print("Fraction: ", frac)

    major_df = major_df.sample(frac=frac, replace=True)

    balanced_df = pd.concat([balanced_df, major_df])


print(balanced_df.categories.value_counts())

# save balanced data
balanced_df.to_pickle("data_files/Perfectly_Balanced_10k.pkl")
















