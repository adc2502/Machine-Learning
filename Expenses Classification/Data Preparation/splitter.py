# Andreas Campbell
# Newcastle University

import gzip
from itertools import zip_longest
import pandas as pd

# code has to be run section at a time.

# creates a new file for each 100,000 lines
def grouper(n, iterable, fillvalue=None):
    "Collect data into fixed-length chunks or blocks"
    # grouper(3, 'ABCDEFG', 'x') --> ABC DEF Gxx
    args = [iter(iterable)] * n
    return zip_longest(fillvalue=fillvalue, *args)
    
# total lines = 9430088
n = 9430088

with open('metadatatext.txt') as f:
    for i, g in enumerate(grouper(n, f, fillvalue=''), 1):
        with open('data_files/SmallerFiles/small_file_{0}'.format(i * n), 'w') as fout:
            fout.writelines(g)

#--------------------------------------------------------------------------------------------------------
# compress to a gzip file

input = open("data_files/SmallerFiles/small_file_9430088.json", 'rb')
s = input.read()
input.close()

output = gzip.GzipFile("data_files/zipped_data.gz", 'wb')
output.write(s)
output.close()

print("done")

#--------------------------------------------------------------------------------------------------------
# creates a dataframe from a gzip file

def parse(path):
  g = gzip.open(path, 'rb')
  for l in g:
    yield eval(l)

def getDF(path):
  i = 0
  df = {}
  for d in parse(path):
    df[i] = d
    i += 1
  return pd.DataFrame.from_dict(df, orient='index')

df = getDF('data_files/zipped_data.gz')
df.to_pickle("data_files/df_amazon.pkl")


