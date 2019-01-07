# my solution
# def hashialize_string(str)
# 	hash_table = Hash.new(0)
# 	str.chars.each{|char| hash_table[char]+=1}
# 	hash_table
# end

# def has_palindrome_permutation(str)
# 	hash_table = hashialize_string(str.downcase) # O(S * log(S)) where S = LEN(str)
# 	double, single = [0] * 2
# 	hash_table.each{|_, char_count| char_count % 2 == 0 ? double+=1 : single = 1} # O(S)
# 	chars_count = hash_table.keys.count
# 	return true if double == chars_count || double + single == chars_count
# 	false
# end # O(S*Log(S) + S) ~= O(S*Log(S))

# puts has_palindrome_permutation('amr')
# puts has_palindrome_permutation('amrma')
# puts has_palindrome_permutation('zbobo')
# puts has_palindrome_permutation('a')
# puts has_palindrome_permutation('abcdedcbf')
# puts has_palindrome_permutation('amrr')
# puts has_palindrome_permutation('aaabb')


# ========================================

# the below solution with bit vector

# this algorithm works with O(LEN(str)), The idea is that, for number N, when you XOR that number with itself the result is zero
# N ^ N == 0, So for a palindrome, we need to check if the string contains an even number of each kind of character, or one of them appears only one time.
# So, when we do (N^N)*K, where K is even number the result will be 0, after that we check if the result of XORing them with the number before it will be zero
# but wait, what why and what if it is a string like this "aabbccd", OK, a ^ a = 0, b ^ b = 0, c ^ c = 0, when you XOR bunch of zeros it will be zero, d will remain
# if we are saying that d will be equals 8 as (1 << (100 - 97)), when you XOR 8 with 0 it will be 8, let's take a second, We said that palindrom will be bunch of 
# characters that appears in even number or one of them will appear in odd, So the result bit vector will be either bunch of zeros or at most one bit will be 1
# and the others will be zeros, making only one bit 1 and the others zeros will be a power of 2, so in binary we can check if a number is a power of 2 or not 
# by ANDing the number and the number previous to it, if the result is 0, it is power of 2 else it is not, so if there is more than a character with odd occurance
# will be the result binary representation has more than 1 in its bits.

def createBit(str)
	bit, num = 0, 0
	str.chars.each do |char|
		num = char.ord - 97
		bit ^= num < 0 ? 0 : (1 << num)
	end
	bit
end

def checkAtMostOneBitSet(b)
	(b & (b-1)) == 0
end

def isPermutationOfPalindrome(str)
	b = createBit(str)
	checkAtMostOneBitSet(b)
end

puts isPermutationOfPalindrome("aadddd")

