
set( SRC_SOURCE
    ${CMAKE_CURRENT_SOURCE_DIR}/twoSum.cpp
    ${CMAKE_CURRENT_SOURCE_DIR}/palidromeNumber.cpp
)

set ( SRC_HEADERS 
    ${CMAKE_CURRENT_SOURCE_DIR}/twoSum.h
    ${CMAKE_CURRENT_SOURCE_DIR}/palidromeNumber.h
)


add_subdirectory(daily)


set ( SOURCE
    ${SOURCE}
    ${SRC_SOURCE}

    PARENT_SCOPE
)

set ( HEADERS
    ${HEADERS}
    ${SRC_HEADERS}

    PARENT_SCOPE
)

set ( INC_DIRECTORIES
    ${INC_DIRECTORIES}
    ${CMAKE_CURRENT_SOURCE_DIR}/daily/

    PARENT_SCOPE
)
