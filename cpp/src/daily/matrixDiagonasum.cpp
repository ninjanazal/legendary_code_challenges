#include "matrixDiagonasum.h"

#include <sstream>
#include <unordered_map>

#include "profileBlock.h"


using namespace LendaryCodeChallenges;
using namespace std;

void MatrixDiagonalSum::execute() {
    printf("--- Matrix Diagonal sum ---\n");

    vector<vector<int>> input = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};
    int result = 0;
    {
        ProfileBlock t;
        result = diagonalSum(input);
    }
    printResult(result);
}

/*
113 / 113 test cases passed.
Status: Accepted
Runtime: 9 ms
Memory Usage: 11.2 MB
*/
int MatrixDiagonalSum::diagonalSum(vector<vector<int>> &mat) {
    int output = 0;
    for (int i = 0; i < mat.size(); i++) {
        output += mat[i][i];
        if (i != mat.size() - 1 - i) {
            output += mat[i][mat.size() - 1 - i];
        }
    }

    return output;
}

void MatrixDiagonalSum::printResult(int result) {
    stringstream ss;
    ss << result;
    std::cout << ss.str() << std::endl;
}
