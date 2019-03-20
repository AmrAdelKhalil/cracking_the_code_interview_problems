class MyStack:

	def __init__(self, number_of_queues, sz_of_queue):
		self.number_of_queues = number_of_queues
		self.sz_of_queue = sz_of_queue
		self.array = [0] * (number_of_queues * sz_of_queue)
		self.pointers = [0] * number_of_queues
		for i in range(number_of_queues):
			self.pointers[i] = (i * sz_of_queue)

	
	def stack_is_full(self, stack_number):
		return self.sz_of_queue == self.pointers[stack_number]

	def push_to_stack(self, stack_number, value):
		stack_number = stack_number - 1
		if self.stack_is_full(stack_number):
			return 'The queue is full'

		self.array[stack_number * self.pointers[stack_number]] = value
		self.pointers[stack_number] += 1

		return value


def run():
	s = MyStack(3, 3)
	print(s.push_to_stack(1,2))
	print(s.push_to_stack(1,3))
	print(s.push_to_stack(1,4))
	print(s.push_to_stack(1,5))


if __name__ == "__main__":
	run()


# The Idea is to make all of them in one array, Knowing the number of queues and the size of each one, then create an array that fits them.
# This solution is OK, but a better solution is by making it expand and overlap, this will help if they have different sizes