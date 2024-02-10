#include <sstream>
#include <vector>

#include "maximumTwinSum.h"
#include "profileBlock.h"

using namespace LendaryCodeChallenges;
using namespace std;

void MaximumTwinSum::execute() {
    printf("--- Swap Pairs ---\n");
    ListNode* input = nullptr;
    vector<int> data = {4, 2, 2, 3};

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

    int output;

    {
        ProfileBlock t;
        output = pairSum(input);
    }

    printResult(output);
}

int MaximumTwinSum::pairSum(ListNode* head) {
    int output = 0;
    vector<int> vals;

    for (ListNode* c = head; c; c = c->next) {
        vals.push_back(c->val);
    }

    for (int i = 0; i < vals.size() / 2; i++) {
        int val = vals[i] + vals[vals.size() - i - 1];
        if (val > output) {
            output = val;
        }
    }

    return output;
}

void MaximumTwinSum::printResult(int result) {
    cout << result << endl;
}