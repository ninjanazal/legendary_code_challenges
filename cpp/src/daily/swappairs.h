#include <iostream>

using namespace std;
namespace LendaryCodeChallenges {
namespace SwapPairs {

struct ListNode {
    int val;
    ListNode* next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode* next) : val(x), next(next) {}
};

void execute();
ListNode* swapPairs(ListNode* head);
void printResult(ListNode* result);
}  // namespace SwapPairs
}  // namespace LendaryCodeChallenges
