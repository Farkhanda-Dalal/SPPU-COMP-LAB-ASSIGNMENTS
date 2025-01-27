Histograms Overview
A histogram is a graphical representation of the distribution of a dataset. It shows how data is divided into intervals (or bins) and helps visualize the frequency of values within each bin.

Key Features of a Histogram
Bins:
Represent ranges of data values.
The height of each bar corresponds to the number of observations in that bin.
Frequency:
A histogram displays the count (or density) of values in each bin.
Purpose:
Shows the shape of the data distribution (e.g., normal, skewed, bimodal).
Helps detect outliers and gaps in the data.
Creating a Histogram with Seaborn
Let’s work with the Titanic dataset to explore its data using histograms and other exploratory data analysis (EDA).

Step 1: Load Titanic Dataset
python
Copy
Edit
import seaborn as sns
import matplotlib.pyplot as plt

# Load the Titanic dataset
titanic = sns.load_dataset("titanic")

# Display the first few rows of the dataset
print(titanic.head())
Step 2: Basic Histogram
Let’s visualize the distribution of passenger ages:

python
Copy
Edit
# Create a histogram for the 'age' column
sns.histplot(titanic['age'], kde=False, bins=20)
plt.title("Age Distribution of Titanic Passengers")
plt.xlabel("Age")
plt.ylabel("Frequency")
plt.show()
