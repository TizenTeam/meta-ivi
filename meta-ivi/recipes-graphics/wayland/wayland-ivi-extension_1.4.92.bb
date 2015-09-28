SUMMARY = "Wayland IVI Extension"
DESCRIPTION = "GENIVI Layer Management API based on Wayland IVI Extension"
HOMEPAGE = "http://projects.genivi.org/wayland-ivi-extension"
BUGTRACKER = "http://bugs.genivi.org/enter_bug.cgi?product=Wayland%20IVI%20Extension"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=176cedb32f48dd58f07e0c1c717b3ea4"

DEPENDS = "weston"

# FIX ME
# This should be TAG = "${PV}" but yocto doesn't support lightweight tags for now
# https://bugzilla.yoctoproject.org/show_bug.cgi?id=6881
TAG = "b3742e20f64d1e64c6bdda1a04752290b9a783e7"
SRC_URI = "git://git.projects.genivi.org/${PN}.git;tag=${TAG} \
          "
S = "${WORKDIR}/git"

inherit cmake autotools

FILES_${PN} += "${libdir}/weston/*"
FILES_${PN}-dbg += "${libdir}/weston/.debug/*"
