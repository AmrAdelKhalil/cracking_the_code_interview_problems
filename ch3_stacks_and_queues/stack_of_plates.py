

class SetOfStack:

	def __init__(self, cap):
		self.capacity = cap
		self.stacks = [[]]
		self.current_stack = 0

	def push(self, _):
		if len(self.stacks[self.current_stack]) >= self.capacity:
			print 'stack is full, make a new one.'
			self.stacks.append([])
			self.current_stack += 1

		self.stacks[self.current_stack].append(_)
		print 'Element has been inserted.'



	def pop(self):
		self.stacks[self.current_stack].pop(len(self.stacks[self.current_stack]) - 1)
		if len(self.stacks[self.current_stack]) == 0:
			print 'remvoe last stack'
			self.stacks.pop(len(self.stacks) - 1)
			self.current_stack -= 1
		print 'element has been popped successfully.'


	def popAt(self, idx):
		self.stacks[idx].pop(len(self.stacks[idx]) - 1)
		for i in range(idx+1, self.current_stack + 1):
			self.stacks[i - 1].append(self.stacks[i][0])
			self.stacks[i].pop(0)

		if len(self.stacks[self.current_stack]) == 0:
			self.stacks.pop(len(self.stacks) - 1)
			self.current_stack -= 1
			print 'remove an empty stack after popAt is called'


def run():
	s = SetOfStack(3)
	s.push(1)
	s.push(2)
	s.push(3)
	s.push(4)
	s.push(5)
	s.push(6)
	s.push(7)
	s.push(8)
	s.push(9)
	s.pop()
	s.pop()
	s.pop()
	s.pop()
	s.popAt(0)
	s.popAt(0)
	print(s.stacks)

if __name__ == "__main__":
	run()