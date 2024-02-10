#include <chrono>
#include <iostream>

namespace LendaryCodeChallenges {
class ProfileBlock {
   private:
    const std::chrono::steady_clock::time_point init;

   public:
    ProfileBlock() : init(std::chrono::steady_clock::now()) {}
    ~ProfileBlock() {
        std::chrono::steady_clock::time_point e = std::chrono::steady_clock::now();
        int16_t duration_ns = std::chrono::duration_cast<std::chrono::nanoseconds>(e - init).count();

        std::cout << "ns -> " << duration_ns << std::endl;
    }
};
}  // namespace LendaryCodeChallenges