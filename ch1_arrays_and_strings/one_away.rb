def one_away_str(base, comparable)
	return true if base == comparable
	return false if (base.size - comparable.size).abs > 1
	base.size == comparable.size ? check_replace(base, comparable) : check_rm_and_add(base, comparable)
end

def check_replace(base, comparable)
	differance, base_iter, comp_iter = [0] * 3
	while base_iter < base.size
		differance += 1 if base[base_iter] != comparable[comp_iter]
		base_iter += 1
		comp_iter += 1
	end
	differance == 1 ? true : false
end

def check_rm_and_add(base, comparable)
	i,j = [0] * 2
	base, comparable = comparable, base if comparable.size > base.size
	while j < base.size
		i += 1 if comparable[i] == base[j]
		j += 1
	end
	i == comparable.size ? true : false
end

puts one_away_str('amd', 'amr')
puts one_away_str('amr', 'am')
puts one_away_str('am', 'amr')
puts one_away_str('a', 'dmr')
puts one_away_str('a', 'dm')
puts one_away_str('amr', 'rma')