#include "twoSum.h"

#include <sstream>
#include <unordered_map>

#include "profileBlock.h"
#include "sortingFuncs.h"

using namespace LendaryCodeChallenges;
using namespace std;

void TwoSum::execute() {
    printf("--- TwoSum ---\n");

    vector<int> input = {1, 6142, 8192, 10239};
    int target = 18431;
    vector<int> output;

    {
        ProfileBlock t;
        output = twoSum(input, target);
    }

    printResult(output);

    {
        ProfileBlock v;
        output = twoSumSecondTry(input, target);
    }

    printResult(output);
}

/// @brief Accepted
///  595 ms / Memory 10MB
vector<int> TwoSum::twoSum(vector<int> &nums, int target) {
    vector<int> output;
    for (int i = 0; i < nums.size(); i++) {
        for (int j = i + 1; j < nums.size(); j++) {
            if (nums[i] + nums[j] == target) {
                output.push_back(i);
                output.push_back(j);
                break;
            }
        }
    }

    return output;
}

/// @brief Accepted
/// @return  17 ms / Mem 10.8 MB
vector<int> TwoSum::twoSumSecondTry(vector<int> &nums, int target) {
    unordered_map<int, uint16_t> parcel_val = {};

    for (int i = 0; i < nums.size(); i++) {
        int rem = target - nums[i];

        if (parcel_val.count(nums[i]) != 0) {
            return {parcel_val[nums[i]], i};
        }
        parcel_val[rem] = i;
    }

    return {};
}

void TwoSum::printResult(vector<int> result) {
    stringstream ss;
    ss << "[ ";
    for (int v : result) {
        ss << v << " ";
    }
    ss << "]";
    std::cout << ss.str() << std::endl;
}
