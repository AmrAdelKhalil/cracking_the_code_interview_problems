class MyStack:

	def __init__(self):
		self.array = []
		self.idx = 0
		self.min_array = []
		self.min_idx = 0

	def _increase_cap(self):
		new_cap = [0] if len(self.array) == 0 else [0] * len(self.array)
		self.array = self.array + new_cap

	def _min_increase_cap(self):
		new_cap = [0] if len(self.min_array) == 0 else [0] * len(self.min_array)
		self.min_array = self.min_array + new_cap

	def push(self,v):
		if self.idx == len(self.array):
			self._increase_cap()


		self.array[self.idx] = v
		self.idx += 1

		if self.min_idx == len(self.min_array):
			self._min_increase_cap()

		if self.min_idx == 0 or self.min_array[self.min_idx-1] >= v:
			self.min_array[self.min_idx] = v
			self.min_idx += 1
		print(v, self.array, self.idx, self.min_array, self.min_idx)

	def min(self):
		return "No elements in stack" if self.min_idx == 0 else self.min_array[self.min_idx - 1]

	def pop(self):
		if self.idx == 0:
			return "No elements in stack"

		self.idx -= 1
		removed_value = self.array[self.idx]

		if removed_value == self.min_array[self.min_idx - 1]:
			self.min_idx -= 1

		return removed_value


def run():
	stack = MyStack()
	stack.push(3)
	stack.push(2)
	stack.push(5)
	stack.push(1)
	print(stack.min())
	stack.pop()
	print(stack.min())


if __name__ == "__main__":
	run()