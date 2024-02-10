#include "uncrossedLines.h"

#include <sstream>
#include <unordered_map>
#include <vector>

#include "profileBlock.h"

using namespace LendaryCodeChallenges;
using namespace std;

void UncrossedLines::execute() {
    printf("--- Uncrossed Lines ---\n");

    //vector<int> nums1 = {1, 4, 2};
    //vector<int> nums2 = {1, 2, 4};

    // vector<int> nums1 = {2, 5, 1, 2, 5};
    // vector<int> nums2 = {10, 5, 2, 1, 5, 2};

    vector<int> nums1 = {3, 1, 4, 1, 1, 3, 5, 1, 2, 2};
    vector<int> nums2 = {4, 1, 5, 2, 1, 1, 1, 5, 3, 1, 1, 1, 2, 3, 1, 4, 3, 5, 5, 3, 1, 2, 3, 2, 4, 1, 1, 1, 5, 3};

    int output = 0;

    {
        ProfileBlock t;
        output = maxUncrossedLines(nums1, nums2);
    }

    printResult(output);
}


// Need to revisit this problem
int UncrossedLines::maxUncrossedLines(vector<int>& nums1, vector<int>& nums2) {
    vector<vector<int>> possible_lines(nums1.size() + 1, vector<int>(nums2.size() + 1, 0));

    for (int i = 1; i <= nums1.size(); i++) {
        for (int j = 1; j <= nums2.size(); j++) {
            if (nums1[i - 1] == nums2[j - 1]) {
                possible_lines[i][j] = possible_lines[i - 1][j - 1] + 1;
            } else {
                possible_lines[i][j] = std::max(possible_lines[i - 1][j], possible_lines[i][j - 1]);
            }
        }
    }

    return possible_lines[nums1.size()][nums2.size()];

    return 0;
}

    // for (int i = 0; i < nums1.size(); i++) {
    //     for (int j = 0; j < nums2.size(); j++) {
    //         if (nums1[i] == nums2[j]) {
    //             for (int poss_id = 0; poss_id < possible_lines.size(); poss_id++) {
    //                 bool novalid = false;

    //                 for (int combination_id = 0; combination_id < possible_lines[poss_id].size(); combination_id++) {
    //                     novalid = (i == possible_lines[poss_id][combination_id][0] || j == possible_lines[poss_id][combination_id][1]) ||
    //                               (i > possible_lines[poss_id][combination_id][0] && j < possible_lines[poss_id][combination_id][1]);

    //                     // if (novalid) {
    //                     //     break;
    //                     // }
    //                 }
    //                 if (!novalid) {
    //                     possible_lines[poss_id].push_back({i, j});
    //                 }
    //             }

    //             possible_lines.push_back({{i, j}});
    //         }
    //     }
    // }

    // int b = 0;
    // for (int i = 0; i < possible_lines.size(); i++) {
    //     if (possible_lines[i].size() > b) {
    //         b = possible_lines[i].size();
    //     }
    // }
    // return b;


void UncrossedLines::printResult(int result) {
    stringstream ss;
    ss << result;
    std::cout << ss.str() << std::endl;
}
