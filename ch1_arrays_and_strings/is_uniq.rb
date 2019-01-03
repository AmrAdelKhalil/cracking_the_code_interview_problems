# taking the string input
str_input = gets.chomp.chars

str_input = str_input.sort

def uniq_string?(str)
	str_length = str.length
	index = 0
	while index < str_length - 1
		return false if str[index] == str[index + 1]
		index += 1
	end
	true
end


puts "You entered '#{str_input.join}' as an input"
puts "String you entered is#{uniq_string?(str_input) ? ' ' : ' not ' }uniq"
puts 'complexity is the sorting time which is O(slogs + s)'