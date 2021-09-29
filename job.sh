#!/bin/sh/env
pip3 install pandas
pip3 install matplotlib
pip3 install sklearn
brew install python3 && cp /usr/local/bin/python3 /usr/local/bin/python
cd src
cd MachineLearning
wait
python3 ml.py
