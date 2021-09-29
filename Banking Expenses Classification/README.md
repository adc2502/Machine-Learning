Banking Expenses Classification

Objective:

The objective was to be able to categorise a users expenses based on the item
name. E.g. If the user bought "red jumper" it should be classified as Clothing.

The end product is a graph detailing what types of items they purchased.

Method/Outcome:

I decided to use an Amazon product dataset as it had millions of products in a
variety of categories. The downside was that it would not include data such as
groceries which would be a common purchase type for a user. Due to a limited
amount of time, I would have to make do without.

Although the products did not have a category field, the dataset included the
products breadcrumbs such as "Fashion>Beauty". This was all I needed to classify
the products.

As seen in the Data Preparation folder, I had to clean the data of useless
information such as stop words and unnecessary fields, before balancing the data
to reduce bias.

I then wrote ml.py which implemented the machine learning aspect of the project
before calculating the % spent on each category and producing a pie chart.

As the banking app was being programmed by my team in Java, I had to create
job.sh which executed the python script.
