#include "palidromeNumber.h"

#include <math.h>

#include <algorithm>
#include <sstream>
#include <vector>

#include "profileBlock.h"

using namespace LendaryCodeChallenges;
using namespace std;

void PalidromNumber::execute() {
    printf("--- Palidrom Number ---\n");
    int input = 1234567899;
    bool output = false;

    {
        ProfileBlock t;
        output = isPalindrome(input);
    }

    printResult(output);

    {
        ProfileBlock t;
        output = isPalindromSecond(input);
    }

    printResult(output);
}

/*
11510 / 11510 test cases passed.
Status: Accepted
Runtime: 28 ms
Memory Usage: 6 MB
*/
bool PalidromNumber::isPalindrome(int x) {
    string inData = to_string(x);
    for (int i = 0; i < floor(inData.size() / 2.0); i++) {
        swap(inData[i], inData[inData.size() - 1 - i]);
    }
    return inData == to_string(x);
}

/*
11510 / 11510 test cases passed.
Status: Accepted
Runtime: 7 ms
Memory Usage: 5.9 MB
*/
bool PalidromNumber::isPalindromSecond(int x) {
    long val = 0;
    int dub = x;
    if (x < 0) {
        return false;
    }
    while (dub != 0) {
        val = val * 10 + dub % 10;
        dub /= 10;
    }

    return val == x;
}

void PalidromNumber::printResult(bool result) {
    stringstream ss;
    ss << result;
    std::cout << ss.str() << std::endl;
}
