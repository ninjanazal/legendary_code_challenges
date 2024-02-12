#include <iostream>
#include <vector>

namespace LendaryCodeChallenges {
namespace MatrixDiagonalSum {

/*
Input: mat = [[1,2,3],
            [4,5,6],
            [7,8,9]]
Output: 25
Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
Notice that element mat[1][1] = 5 is counted only once.
*/
void execute();
int diagonalSum(std::vector<std::vector<int>>& mat);
void printResult(int result);

}  // namespace MatrixDiagonalSum
}  // namespace LendaryCodeChallenges