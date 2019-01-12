def memo_matrix(matrix)
	r_count = [0]*matrix.count
	c_count = [0]*matrix[0].count
	matrix.each_with_index do |row, r_idx|
		row.each_with_index do |cell, c_idx|
			if cell == 0
				r_count[r_idx] += 1
				c_count[c_idx] += 1
			end
		end
	end
	[r_count, c_count]
end

def validate_matrix(matrix, memo)
	matrix.each_with_index do |row, r_idx|
		row.each_with_index do |cell, c_idx|
			if cell == 0 && (memo[0][r_idx] != matrix.count || memo[1][c_idx] != matrix[0].count)
				return false
			end
		end
	end
	true
end

# the above algorithm is O(ROW*COL + ROW*COL)

matrix = [[1,2],[3,4]]
puts validate_matrix(matrix, memo_matrix(matrix))


# I've noticed somthing, if we redefined the problem we will see that it is only true if matrix does not contain zero or it is only contains zeros
# we can generate algorithm that will be O(COL*ROW) to count the number of zeros and just a condition to check that count if 0 or equal N*M it is 
# true, false otherwise.