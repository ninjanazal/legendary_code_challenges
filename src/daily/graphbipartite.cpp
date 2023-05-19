#include "graphbipartite.h"

#include <set>
#include <sstream>
#include <unordered_map>

#include "profileBlock.h"

using namespace LendaryCodeChallenges;
using namespace std;

void GraphBipartite::execute() {
    printf("----- Graph Bipartite -----\n");
    //vector<vector<int>> input = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
    vector<vector<int>> input = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
    // vector<vector<int>> input = {{4, 1}, {0, 2}, {1, 3}, {2, 4}, {3, 0}};
    //vector<vector<int>> input = {{1}, {0, 3}, {3}, {1, 2}};
    // vector<vector<int>> input = {{1, 2, 3}, {0, 3, 4}, {0, 3}, {0, 1, 2}, {1}};

    bool output;

    {
        ProfileBlock t;
        output = isBipartite(input);
    }
    printResult(output);
}

bool GraphBipartite::isBipartite(vector<vector<int>>& graph) {
    unordered_map<int, set<int>> data;
    int v_size = graph.size();
    int b_size = 0;

    for (int it = 0; it < graph.size(); it++) {
        if (graph[it].size() == 0) {
            v_size--;
        }

        for (int x = 0; x < graph[it].size(); x++) {
            data[graph[it][x]].insert(it);
            if(data[graph[it][x]].size() > b_size){
                b_size = data[graph[it][x]].size();
            }
        }
    }

    if(v_size % 2 != 0){
        return false;
    }

    for (unordered_map<int, set<int>>::iterator it = data.begin(); it != data.end(); ++it) {
        if (data[it->first].size() % 2 != 0 && data[it->first].size() * 2 != b_size) {
            return false;
        }

        for (int val : it->second) {
            if (val == it->first) {
                return false;
            }
            if (data[val].find(it->first) == data[val].end()) {
                return false;
            }
        }
    }
    return true;
}

void GraphBipartite::printResult(bool result) {
    stringstream ss;
    ss << result;

    std::cout << ss.str() << std::endl;
}