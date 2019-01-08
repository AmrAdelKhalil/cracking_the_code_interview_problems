def compress(str)
	compressed_str = ''
	count, idx = 0, 0
	while idx < str.size
		idx += 1 and count += 1 and next if idx == 0
		if str[idx] != str[idx - 1]
			compressed_str << str[idx - 1] << count.to_s
			count = 0
		end
		count += 1
		idx += 1
	end
	compressed_str << str[idx - 1] << count.to_s if count > 0
	str.size < compressed_str.size ? str : compressed_str
end


puts compress('aabcccccaaa')
puts compress('a')
puts compress('abcc')
puts compress('aA')