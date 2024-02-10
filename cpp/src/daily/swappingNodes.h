#include <iostream>

using namespace std;
namespace LendaryCodeChallenges {
namespace SwappingNodes {

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

void execute();
ListNode* swapNodes(ListNode* head, int k);
void printResult(ListNode* result);
}  // namespace SwappingNodes
}  // namespace LendaryCodeChallenges
