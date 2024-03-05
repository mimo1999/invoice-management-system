import pickle
file = open("le.obj",'rb')
enc = pickle.load(file)
file.close()
map = dict(zip(enc.classes_, range(len(enc.classes_))))
print(map)