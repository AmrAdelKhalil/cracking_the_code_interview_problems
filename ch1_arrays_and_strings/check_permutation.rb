# get input as (amr adel)
s, l = gets.chomp.split

def convert_to_map(str)
	hash = Hash.new(0)
	str.chars.each {|char| hash[char] += 1}
	hash
end


s_hash = convert_to_map(s)

l.chars.each {|char| s_hash[char] -= 1}

is_permutation = (s_hash.reject!{|_, value| value.zero?}.empty?) ? true : false
puts "#{s} is#{is_permutation ? ' ' : ' not '}a permutation of #{l}"