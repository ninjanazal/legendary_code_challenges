#include "minimunverticestoreach.h"

#include <sstream>
#include <unordered_map>

#include "profileBlock.h"

using namespace LendaryCodeChallenges;
using namespace std;

void MinimunVerticesToReach::execute() {
    printf("----- Minimun Vertices to Reach -----\n");

    // vector<vector<int>> input = {{0, 1}, {0, 2}, {2, 5}, {3, 4}, {4, 2}};
    vector<vector<int>> input = {{1,2},{1,0},{0,2}};

    int n = 3;

    vector<int> output;
    {
        ProfileBlock t;
        output = findSmallestSetOfVertices(n, input);
    }

    printResult(output);
}

vector<int> MinimunVerticesToReach::findSmallestSetOfVertices(int n, vector<vector<int>>& edges) {
    vector<int> output;
    unordered_map<int, int> relations;

    for (int i = 0; i < edges.size(); i++) {
        relations[edges[i][1]] = edges[i][1];
    }

    for (int i = 0; i < n; i++) {
        if (!relations.count(i)) {
            output.push_back(i);
        }
    }

    return output;
}

void MinimunVerticesToReach::printResult(vector<int> result) {
    stringstream ss;
    for (int val : result) {
        ss << val << " ";
    }
    std::cout << ss.str() << std::endl;
}