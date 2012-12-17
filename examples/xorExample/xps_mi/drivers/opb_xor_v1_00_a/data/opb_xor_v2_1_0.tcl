##############################################################################
## Filename:          /home/kheyse/private/tlut_flow/examples/xorExample/ise/drivers/opb_xor_v1_00_a/data/opb_xor_v2_1_0.tcl
## Description:       Microprocess Driver Command (tcl)
## Date:              Fri Dec  7 16:39:31 2012 (by Create and Import Peripheral Wizard)
##############################################################################

#uses "xillib.tcl"

proc generate {drv_handle} {
  xdefine_include_file $drv_handle "xparameters.h" "opb_xor" "NUM_INSTANCES" "DEVICE_ID" "C_BASEADDR" "C_HIGHADDR" 
}
