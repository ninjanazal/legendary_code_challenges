#include "romantointeger.h"

#include <algorithm>
#include <sstream>
#include <unordered_map>
#include <vector>

#include "profileBlock.h"

using namespace LendaryCodeChallenges;
using namespace std;

void RomanToInteger::execute() {
    printf("--- roman to int ---\n");
    // string input = "III";
    string input = "MCMXCIV";

    int output;

    {
        ProfileBlock t;
        output = romanToInt(input);
    }

    printResult(output);

    {
        ProfileBlock t;
        output = romanToIntSecond(input);
    }

    printResult(output);
}

int RomanToInteger::romanToInt(string s) {
    unordered_map<char, int> relation = {
        {'M', 1000},
        {'D', 500},
        {'C', 100},
        {'L', 50},
        {'X', 10},
        {'V', 5},
        {'I', 1},
    };

    unordered_map<char, vector<char>> mods = {
        {'I', {'V', 'X'}},
        {'X', {'L', 'C'}},
        {'C', {'D', 'M'}}};

    int output = 0;

    for (int i = 0; i < s.length(); i++) {
        char c = s[i];
        if (i + 1 < s.length()) {
            const char next = s[i + 1];
            if (mods.count(c) != 0 && find(mods[c].begin(), mods[c].end(), next) != mods[c].end()) {
                output += relation[next] - relation[c];
                i++;
                continue;
            }
        }

        output += relation[c];
    }

    return output;
}

int RomanToInteger::romanToIntSecond(string s) {
    unordered_map<char, int> relation = {
        {'M', 1000},
        {'D', 500},
        {'C', 100},
        {'L', 50},
        {'X', 10},
        {'V', 5},
        {'I', 1},
    };

    int output = 0;

    for (int i = 0; i < s.length(); i++) {
        char c = s[i];
        if (i + 1 < s.length()) {
            const char next = s[i + 1];
            switch (c) {
                case 'I':
                    if (next == 'V' || next == 'X') {
                        output += relation[next] - relation[c];
                        i++;
                        continue;
                    }
                    break;
                case 'X':
                    if (next == 'L' || next == 'C') {
                        output += relation[next] - relation[c];
                        i++;
                        continue;
                    }
                    break;

                case 'C':
                    if (next == 'D' || next == 'M') {
                        output += relation[next] - relation[c];
                        i++;
                        continue;
                    }
					break;
            }
        }

        output += relation[c];
    }

    return output;
}

void RomanToInteger::printResult(int result) {
    std::cout << "Result: " << result << std::endl;
}