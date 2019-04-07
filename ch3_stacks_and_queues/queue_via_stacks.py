# This is an easy one, So I choose to write the idea
# The queue class got two stacks, when we push into the queue we push in the first stack, Once
# we need to pop from the queue (getting the first element), we pop everything in the first stack and put it in the second stack
# and pop the element on the top.


# the issue is that if we tried to make the pop every time we will go throw the first stack, but we can use lazy approach, we won't put things back to first stack
# till we get a push, I know if we make push and pop following each other this will cause the same problem.