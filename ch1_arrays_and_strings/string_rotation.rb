def check_rotation(s1, s2)
	return false if s1.length != s2.length
	isSubstring(s1, "#{s2}#{s2}")
end

# isSubstring I assumed it will give true or false, the idea is that, if we added s2 to itself and if it is a rotation the original string will be in the middle

puts check_rotation("amr","mra")