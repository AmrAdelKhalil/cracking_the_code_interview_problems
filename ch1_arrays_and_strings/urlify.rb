def URLify(str, length)
	str = str.strip # O(len(str))
	modified = []
	idx = 0
	str.chars.each do |char| # O(len(str))
		if char == ' '
			['%', '2', '0'].each{|special_char| modified[idx] = special_char; idx += 1} # O(3) I believe we can consider this as a constant.
		else
			modified[idx] = char
			idx += 1
		end
	end
	modified
end

puts URLify("Mr John Smith    ", 13).join # O(len(modified))

# overall complexity is O(len(str) + len(str) + len(modified))