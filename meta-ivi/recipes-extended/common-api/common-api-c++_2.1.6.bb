SUMMARY = "CommonAPI"
SECTION = "libs"
LICENSE = "MPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=815ca599c9df247a0c7f619bab123dad"
PROVIDES = "common-api2"
PR = "r0"

#SRC_URI = "git://git.projects.genivi.org/ipc/common-api-runtime.git;protocol=http;tag=${PV}"
#S = "${WORKDIR}/git"
SRC_URI = "file://common-api-runtime-188abb5.tar.gz"
S = "${WORKDIR}/common-api-runtime-188abb5"

CXXFLAGS := "${@oe_filter_out('-fvisibility-inlines-hidden', '${CXXFLAGS}', d)}"

inherit autotools lib_package pkgconfig
