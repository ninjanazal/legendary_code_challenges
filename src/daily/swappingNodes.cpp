#include "swappingNodes.h"

#include <sstream>
#include <vector>

#include "profileBlock.h"

using namespace LendaryCodeChallenges;
using namespace std;

void SwappingNodes::execute() {
    printf("--- Spiral Matrix ---\n");
    SwappingNodes::ListNode* input;
    vector<int> data = {7, 9, 6, 6, 7, 8, 3, 0, 9, 5};
    int k = 5;

    SwappingNodes::ListNode* cur = nullptr;
    for (int i = 0; i < data.size(); i++) {
        SwappingNodes::ListNode* next = new SwappingNodes::ListNode(data[i]);
        if (input == nullptr) {
            input = next;
        } else {
            cur->next = next;
        }
        cur = next;
    }

    SwappingNodes::ListNode* output;

    {
        ProfileBlock t;
        output = swapNodes(input, k);
    }
    printResult(output);
}

SwappingNodes::ListNode* SwappingNodes::swapNodes(ListNode* head, int k) {
    ListNode* c = head;
    vector<ListNode*> nodes;

    int counter = -1;
    while (c) {
        nodes.push_back(c);
        counter++;
        c = c->next;
    }

    k--;
    if (nodes[k]->val == nodes[counter - k]->val) {
        return head;
    }

    swap(nodes[k]->val, nodes[counter - k]->val);
    return head;
}

void SwappingNodes::printResult(ListNode* result) {
    ListNode* c = result;
    while (c->next) {
        cout << " " << c->val << endl;
        c = c->next;
    }
}
