#include "swappairs.h"

#include <sstream>
#include <vector>

#include "profileBlock.h"

using namespace LendaryCodeChallenges;
using namespace std;

void SwapPairs::execute() {
    printf("--- Swap Pairs ---\n");
    ListNode* input = nullptr;
    vector<int> data = {1};

    ListNode* cur = nullptr;
    for (int i = 0; i < data.size(); i++) {
        ListNode* next = new ListNode(data[i]);
        if (input == nullptr) {
            input = next;
        } else {
            cur->next = next;
        }
        cur = next;
    }

    ListNode* output;

    {
        ProfileBlock t;
        output = swapPairs(input);
    }
    printResult(output);
}

SwapPairs::ListNode* SwapPairs::swapPairs(ListNode* head) {
    if (head == nullptr) {
        return head;
    }

    ListNode* prev = nullptr;
    ListNode* left = head;
    ListNode* right = left->next;

    if (right) {
        head = right;
    }

    while (right) {
        left->next = right->next;
        right->next = left;

        if (prev) {
            prev->next = right;
        }

        prev = left;
        left = prev->next;
        right = nullptr;

        if (left) {
            right = left->next;
        }
    }

    return head;
}

void SwapPairs::printResult(ListNode* result) {
    ListNode* c = result;
    while (c) {
        cout << " " << c->val << endl;
        c = c->next;
    }
}
