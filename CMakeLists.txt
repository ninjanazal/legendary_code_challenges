cmake_minimum_required(VERSION 3.8)

set(CMAKE_CXX_STANDARD 17)

if(NOT CMAKE_BUILD_TYPE)
  set(CMAKE_BUILD_TYPE Release)
endif()

set(CMAKE_CXX_FLAGS_DEBUG "-g")
set(CMAKE_CXX_FLAGS_RELEASE "-O3")

project(LegendaryCodeChallenges LANGUAGES CXX)


set( SOURCE 
    ${CMAKE_CURRENT_SOURCE_DIR}/main.cpp
)

set ( HEADERS )

set ( INC_DIRECTORIES
  tools/
  src/
)

add_subdirectory(tools)
add_subdirectory(src)

add_executable(${PROJECT_NAME} ${HEADERS} ${SOURCE})

target_include_directories(${PROJECT_NAME} PRIVATE ${INC_DIRECTORIES})
