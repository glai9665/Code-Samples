names = []
with open('ALL_NAME.csv') as filehandle:
	for line in filehandle:
		names.append(line.split(','))

#shuffle
import random
random.shuffle(names)

#get the Y axis (ethinicity) for the machine learning training
Y = [i[-1].strip() for i in names]


#the above is equivalent to 
#Y = []
#for i in names:
#	Y.append(i[-1].strip())#
#[-1] is the last one 
#strip() means getting just the plain next

from nltk.util import ngrams
from sklearn.feature_extraction import DictVectorizer

def feature_extractor(input_name):
	#extract ngrams
	disected_grams = {}
	#ngrams(input, number of grams)
	for j in ngrams(input_name, 3, pad_left=True, pad_right=True):
		disected_grams[j] = 1 #set each disected gram/part/feature to 1 in the dictionary disected_gram
	#for j in ngrams(input_name, 2, pad_left=True, pad_right=True):
		#disected_grams[j] = 1 #set each disected gram/part/feature to 1 in the dictionary disected_gram	
	#for j in ngrams(input_name, 1, pad_left=True, pad_right=True):
	#	if j not in disected_grams:
	#		disected_grams[j] = 1 #set each disected gram/part/feature to 1 in the dictionary disected_gram	
	#	else:
	#		disected_grams[j] += 1
	return disected_grams

X = []
for k in names:
	X.append(feature_extractor(k[0]))
#k[0] is the first part of every element, which is name, because it's [name, gender, nationality]
#Now X is a dictionary with each dissected gram set to 1

vec = DictVectorizer() #turn each disected_grams into a vector
X = vec.fit_transform(X) 
#for each name, intialize a vector with every feature set to 0, the length of the vector is the total number of all dissected grams (features)
#iterate over each name, assign 1 to its corresponding feature if it is found in the name, the rest remains 0

#import the machine learning algorithm logistic regression
from sklearn.linear_model import LogisticRegression
fred = LogisticRegression()

from sklearn.model_selection import cross_val_score
scores = cross_val_score(fred, X, Y, cv=10) #cross validation, divide data into 10 folds
print sum(scores)/len(scores) #get the average of the accuracy


fred.fit(X,Y) #feed the training data to the algorithm, into fred
print fred.predict(vec.transform(feature_extractor('Schutz')))

