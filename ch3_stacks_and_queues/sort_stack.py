class SortedStack:
	def __init__(self):
		self.stack = []
		self.temp_stack = []

	def push(self, v): # this will take O(len(stack)*2) as a complexity for the worst case
		while len(self.stack) > 0 and self.stack[len(self.stack)-1] < v:
			self.temp_stack.append(self.stack.pop(len(self.stack) - 1))

		self.stack.append(v)

		idx = 0

		while idx < len(self.temp_stack):
			self.stack.append(self.temp_stack[idx])
			idx += 1

		self.temp_stack = []

	def print_stack(self):
		idx = 0
		while idx < len(self.stack):
			print self.stack[idx]
			idx += 1

	# the rest of functionalities are generic



def run():
	s = SortedStack()
	s.push(1)
	s.push(3)
	s.push(2)
	s.push(9)
	s.push(7)
	s.print_stack()

if __name__ == '__main__':
	run()