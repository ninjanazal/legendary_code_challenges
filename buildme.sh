#!/usr/bin/env bash

#- - - - - - - - - - - - - - - - - - - -
# @Values
CURRENT_PATH=$PWD

#- - - - - - - - - - - - - - - - - - - -
CLEAR_ALL=FALSE

#- - - - - - - - - - - - - - - - - - - -
BUILDPROJ=FALSE

#- - - - - - - - - - - - - - - - - - - -
RUNPROJ=FALSE

DEBUGMODE=FALSE



#- - - - - - - - - - - - - - - - - - - -
PrintHelp () {
	echo -e "______________________________________________________________________"
	echo -e "Build help for the project                                           |" 
	echo -e "_____________________________________________________________________|"
	echo -e "*-r (--run)       | Will run the compilation result                  |"
	echo -e "*-br (--buildrun) | Will Build  and run the project                  |"
	echo -e "*-c (--clearall)  | Will clear the previous compilation and rebuild  |"
	echo -e "_____________________________________________________________________|"
}



#- - - - - - - - - - - - - - - - - - - -
#- - - - - - - - - - - - - - - - - - - -
for i in "$@"; do
	case $i in
		-c|--clearall)
            CLEAR_ALL=TRUE
            shift
            ;;
		
        -r|--run)
            RUNPROJ=TRUE
            shift
            ;;
        
        -b|--build)
            BUILDPROJ=TRUE
            shift
            ;;

        -br|--buildrun)
            BUILDPROJ=TRUE
            RUNPROJ=TRUE
            shift
            ;;


        -h|--help)
			PrintHelp
			exit 0
	esac
done


if [ "$CLEAR_ALL" = TRUE ]; then
    rm Build -R -rf
fi

if [ ! -d "Build" ]; then
	mkdir Build
fi

cd Build

if [ "$DEBUGMODE" = TRUE ]; then
    cmake -G "MinGW Makefiles" .. -DCMAKE_BUILD_TYPE=Debug
else
    cmake -G "MinGW Makefiles" .. -DCMAKE_BUILD_TYPE=Release
fi

cd ..

if [ "$BUILDPROJ" = TRUE ]; then
    cd Build
    cmake --build .
    cd ..
fi

if [ "$RUNPROJ" == TRUE ]; then
    ./Build/LegendaryCodeChallenges.exe
fi
