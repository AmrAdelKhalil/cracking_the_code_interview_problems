import datetime
class Animal(Object):
	def __init__(self, type, timestamp)
		self.type = type
		self.timestamp = timestamp
	
	def type(self):
		return self.type

	def timestamp(self):
		reutrn self.timestamp

class Dog(Animal):
	def __init__(self):
		super(Dog, self).__init__('Dog', datetime.datetime.now())

class Cat(Animal):
	def __init__(self):
		super(Cat, self).__init__('Cat', datetime.datetime.now())


class AnimalShelter:
	def __init__(self):
		self.cat_queue = []
		self.dog_queue = []

	def enqeue(self, type):
		if type == 'Dog':
			self.dog_queue.append(Dog())
		else:
			self.cat_queue.append(Cat())

	def dequeueAny(self):
		if len(self.cat_queue) == 0 and len(self.dog_queue) == 0:
			return 'NO THING HAPPENED'
		elif len(self.cat_queue) == 0:
			return self.dog_queue.pop(0)
		elif len(slef.dog_queue) == 0:
			return self.cat_queue.pop(0)
		elif self.cat_queue[0].timestamp > self.dog_queue[0].timestamp:
			return self.cat_queue.pop(0)
		else:
			return self.dog_queue.pop(0)

	def dequeueCat(self):
		if len(self.cat_queue) > 0:
			return self.cat_queue.pop(0)

	def dequeueDog(self):
		if len(self.dog_queue) > 0:
			return self.dog_queue.pop(0)



if __name__ == "__main__":
	run()