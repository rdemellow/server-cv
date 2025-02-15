return {
    // 2018-02-01: cbdeps are now compiled with GCC 7
    // (see https://issues.couchbase.com/browse/CBD-2151).
    // We therefore need to ensure that clang uses GCC7's libstdc++
    // (and not the default GCC 5). As GCC 7 is installed in /usr/local,
    // clang doesn't automatically detect it, so we need to explicitly
    // tell it to use the toolchain in /usr/local.
    CMAKE_ARGS="-DCMAKE_C_COMPILER_EXTERNAL_TOOLCHAIN=/usr/local " +
               "-DCMAKE_CXX_COMPILER_EXTERNAL_TOOLCHAIN=/usr/local" +
               " -DBUILD_ENTERPRISE=1"

    ENABLE_ADDRESSSANITIZER=1
    ENABLE_UNDEFINEDSANITIZER=1
    UBSAN_OPTIONS="print_stacktrace=1"
    ASAN_OPTIONS="abort_on_error=true disable_coredump=0 use_madv_dontdump=1"

    // 2017-05-26: ubuntu16.04 machines are currently 4 cores with 8GB RAM -
    // constrain parallelism so we don't swap (too much)...
    PARALLELISM=6
    TEST_PARALLELISM=3
}
