#include <iostream>
#include <vector>


namespace LendaryCodeChallenges{
        namespace TwoSum{

        /*
        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]
        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
        */
        void execute();
        
        std::vector<int> twoSum(std::vector<int>& nums, int target);
        std::vector<int> twoSumSecondTry(std::vector<int>& nums, int target);

        void printResult(std::vector<int> result);
        }


}