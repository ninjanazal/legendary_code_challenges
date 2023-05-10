#include "spiralMatrix.h"

#include <math.h>

#include <algorithm>
#include <sstream>
#include <vector>

#include "profileBlock.h"

using namespace LendaryCodeChallenges;
using namespace std;

void SpiralMatrix::execute() {
    printf("--- Spiral Matrix ---\n");
    vector<vector<int>> input = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
    // vector<vector<int>> input = {{7}, {9}, {6}};
    // vector<vector<int>> input = {{1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}, {10}};
    // vector<vector<int>> input = {{2, 5}, {8, 4}, {0, -1}};
    // vector<vector<int>> input = {{1, 11}, {2, 12}, {3, 13}, {4, 14}, {5, 15}, {6, 16}, {7, 17}, {8, 18}, {9, 19}, {10, 20}};

    vector<int> output;

    {
        ProfileBlock t;
        output = spiralOrder(input);
    }

    printResult(output);

	std::count << " second --- " << std::endl;

	{
		ProfileBlock t;
		output = spiralOrderSecond(input);
	}

    printResult(output);

}

vector<int> SpiralMatrix::spiralOrder(vector<vector<int>>& matrix) {
    vector<int> output;
    bool updow = true;
    vector<vector<int>> data = matrix;

    while (data.size() != 0) {
        if (updow) {
            for (int i = 0; i < data[0].size(); i++) {
                output.push_back(data[0][i]);
            }

            data.erase(data.begin());

            for (int i = 0; i < data.size(); i++) {
                output.push_back(data[i][data[i].size() - 1]);
                data[i].erase(data[i].end() - 1);

                if (data[i].size() == 0) {
                    data.erase(data.begin() + i);
                    if (data.size() == 0) {
                        break;
                    }
                    i--;
                }
            }

            updow = false;
        } else {
            for (int i = data[data.size() - 1].size() - 1; i >= 0; i--) {
                output.push_back(data[data.size() - 1][i]);
            }

            data.erase(data.end() - 1);

            for (int i = data.size() - 1; i >= 0; i--) {
                output.push_back(data[i][0]);
                data[i].erase(data[i].begin());

                if (data[i].size() == 0) {
                    data.erase(data.begin() + i);
                    if (data.size() == 0) {
                        break;
                    }
                }
            }
            updow = true;
        }
    }
    return output;
}

vector<int> SpiralMatrix::spiralOrderSecond(vector<vector<int>>& matrix) {
    vector<int> output;
    int mat_size[2] = {(int)matrix.size(), (int)matrix[0].size()};
    bool d = false;

    while (mat_size[0] + mat_size[1] != 0) {
    }

    return output;
}

void SpiralMatrix::printResult(vector<int> result) {
    stringstream ss;
    for (int val : result) {
        ss << val << " ";
    }
    std::cout << ss.str() << std::endl;
}
