SUMMARY = "CommonAPI"
SECTION = "libs"
LICENSE = "MPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=815ca599c9df247a0c7f619bab123dad"
PROVIDES = "commonapi3"
PR = "r1"

inherit autotools cmake lib_package pkgconfig

SRC_URI = "git://git.projects.genivi.org/ipc/common-api-runtime.git;branch=master;tag=${PV};protocol=http"
S = "${WORKDIR}/git"

EXTRA_OECMAKE += "-DCMAKE_INSTALL_PREFIX=/usr"

do_configure_prepend () {
  sed -i '/ set(${var} /c  set(ABSOLUTE_${var} "${CMAKE_INSTALL_PREFIX}/${${var}}") ' ${S}/CMakeLists.txt
  sed -i '/file(RELATIVE_PATH /c  file(RELATIVE_PATH REL_INCLUDE_DIR "${ABSOLUTE_INSTALL_CMAKE_DIR}" "${ABSOLUTE_INSTALL_INCLUDE_DIR}") ' ${S}/CMakeLists.txt
}

FILES_${PN}-dev += "${libdir}/cmake"
