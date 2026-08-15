# DIGITAL CLOCK AND ALARM SYSTEM

# DATA SECTION
.data

# CURRENT CLOCK TIME VARIABLES
curr_hours:        .word 0          # Stores current hours
curr_minutes:      .word 0          # Stores current minutes
curr_seconds:      .word 0          # Stores current seconds

# ALARM TIME VARIABLES
alarm_hours:       .word 0          # Stores alarm hours
alarm_minutes:     .word 0          # Stores alarm minutes
alarm_seconds:     .word 0          # Stores alarm seconds

# SYSTEM CONTROL FLAGS
alarm_enabled:     .word 0          # 1 = alarm enabled
led_state:         .word 0          # 1 = LED ON
stop_clock:        .word 0          # 1 = stop clock loop

# SOFTWARE DELAY VALUE
DELAY_COUNT:       .word 2000000    # Delay loop value

# USER INTERFACE MESSAGES
msg_banner:        .asciiz "\n=== DIGITAL CLOCK & ALARM SYSTEM ===\n"

msg_menu1:         .asciiz "[1] Set Current Time\n"
msg_menu2:         .asciiz "[2] Set Alarm Time\n"
msg_menu3:         .asciiz "[3] Start Clock\n"
msg_menu4:         .asciiz "[4] Exit\n"

msg_choice:        .asciiz "Choice: "

msg_enter_h:       .asciiz "Hours   (0-23): "
msg_enter_m:       .asciiz "Minutes (0-59): "
msg_enter_s:       .asciiz "Seconds (0-59): "

msg_time_ok:       .asciiz "[OK] Current time set.\n"
msg_alarm_ok:      .asciiz "[OK] Alarm time set.\n"

msg_invalid:       .asciiz "[ERROR] Invalid input.\n"

msg_colon:         .asciiz ":"
msg_zero:          .asciiz "0"

msg_time_label:    .asciiz "Time: "
msg_led_label:     .asciiz "  LED: "

msg_led_on:        .asciiz "ON\n"
msg_led_off:       .asciiz "OFF\n"

msg_alarm_ring:    .asciiz "\n*** ALARM ACTIVATED ***\n"

msg_snooze:        .asciiz "Snooze? (1=Yes / 0=No): "
msg_snoozed:       .asciiz "[SNOOZE] Alarm delayed by 5 minutes.\n"

msg_running:       .asciiz "\nClock running...\n"

msg_bye:           .asciiz "\nGoodbye.\n"

# CODE SECTION
.text
.globl main

# MAIN PROGRAM
main:
    la $a0, msg_banner   # Load banner message address
    li $v0, 4            # Syscall 4 = print string
    syscall              # Print banner

# MAIN MENU LOOP
main_loop:
    la $a0, msg_menu1    # Print menu option 1
    li $v0, 4
    syscall

    la $a0, msg_menu2    # Print menu option 2
    li $v0, 4
    syscall

    la $a0, msg_menu3    # Print menu option 3
    li $v0, 4
    syscall

    la $a0, msg_menu4    # Print menu option 4
    li $v0, 4
    syscall

    la $a0, msg_choice    # Print choice prompt
    li $v0, 4
    syscall

    li $v0, 5    # Syscall 5 = read integer 
    syscall      # Read user input

    move $s0, $v0                  # Store input in $s0
    li $t0, 1                      # Compare input with 1
    beq $s0, $t0, menu_set_time    # If equal go to set time

    li $t0, 2                       # Compare input with 2
    beq $s0, $t0, menu_set_alarm    # If equal go to set alarm

    li $t0, 3                       # Compare input with 3
    beq $s0, $t0, menu_run_clock    # If equal start clock

    li $t0, 4                  # Compare input with 4
    beq $s0, $t0, menu_exit    # If equal exit program

    la $a0, msg_invalid    # Invalid input message
    li $v0, 4
    syscall

    j main_loop    # Return to menu

# MENU OPTION 1
menu_set_time:
    jal setCurrentTime   # Call setCurrentTime function
    j main_loop          # Return to menu

# MENU OPTION 2
menu_set_alarm:
    jal setAlarmTime        # Call setAlarmTime function
    j main_loop             # Return to menu

# MENU OPTION 3
menu_run_clock:
    jal runClock        # Call runClock function
    j main_loop         # Return to menu

# MENU OPTION 4
menu_exit:
    la $a0, msg_bye   # Load goodbye message
    li $v0, 4         # Print string syscall
    syscall           # Print goodbye message

    li $v0, 10    # Syscall 10 = exit program
    syscall       # Exit

# FUNCTION: setCurrentTime
setCurrentTime:
    addi $sp, $sp, -4     # Allocate stack memory
    sw $ra, 0($sp)        # Save return address
    
# READ HOURS
    la $a0, msg_enter_h    # Ask for hours
    li $v0, 4
    syscall

    li $v0, 5    # Read integer
    syscall

    move $t0, $v0            # Store value in $t0
    bltz $t0, sct_invalid    # Check if negative

    li $t1, 24                   # Check if >= 24
    bge $t0, $t1, sct_invalid
    sw $t0, curr_hours           # Save hours

# READ MINUTES
    la $a0, msg_enter_m    # Ask for minutes
    li $v0, 4
    syscall

    li $v0, 5    # Read integer
    syscall
    
    move $t0, $v0            # Store input
    bltz $t0, sct_invalid    # Check if negative

    li $t1, 60                 # Check if >= 60
    bge $t0, $t1, sct_invalid
    sw $t0, curr_minutes        # Save minutes

# READ SECONDS
    la $a0, msg_enter_s    # Ask for seconds
    li $v0, 4
    syscall

    li $v0, 5    # Read integer
    syscall

    move $t0, $v0            # Store input
    bltz $t0, sct_invalid    # Check if negative

    li $t1, 60                 # Check if >= 60
    bge $t0, $t1, sct_invalid
    sw $t0, curr_seconds       # Save seconds

    la $a0, msg_time_ok    # Print success message
    li $v0, 4
    syscall

    j sct_done    # Jump to end

# INVALID INPUT
sct_invalid:
    la $a0, msg_invalid    # Print invalid message
    li $v0, 4
    syscall

# FUNCTION END
sct_done:
    lw $ra, 0($sp)      # Restore return address
    addi $sp, $sp, 4    # Restore stack
    jr $ra              # Return

# FUNCTION: setAlarmTime
setAlarmTime:
    addi $sp, $sp, -4    # Allocate stack memory
    sw $ra, 0($sp)       # Save return address

# READ ALARM HOURS
    la $a0, msg_enter_h
    li $v0, 4
    syscall

    li $v0, 5
    syscall

    move $t0, $v0
    bltz $t0, sat_invalid

    li $t1, 24
    bge $t0, $t1, sat_invalid
    sw $t0, alarm_hours

# READ ALARM MINUTES
    la $a0, msg_enter_m
    li $v0, 4
    syscall

    li $v0, 5
    syscall

    move $t0, $v0
    bltz $t0, sat_invalid

    li $t1, 60
    bge $t0, $t1, sat_invalid
    sw $t0, alarm_minutes

# READ ALARM SECONDS
    la $a0, msg_enter_s
    li $v0, 4
    syscall

    li $v0, 5
    syscall

    move $t0, $v0
    bltz $t0, sat_invalid

    li $t1, 60
    bge $t0, $t1, sat_invalid
    sw $t0, alarm_seconds

# ENABLE ALARM
    li $t0, 1
    sw $t0, alarm_enabled

# SUCCESS MESSAGE
    la $a0, msg_alarm_ok
    li $v0, 4
    syscall

    j sat_done

# INVALID INPUT
sat_invalid:
    la $a0, msg_invalid
    li $v0, 4
    syscall

# FUNCTION END
sat_done:
    lw $ra, 0($sp)
    addi $sp, $sp, 4
    jr $ra

# FUNCTION: runClock
runClock:
    addi $sp, $sp, -8    # Allocate stack memory
    sw $ra, 4($sp)       # Save return address
    sw $s1, 0($sp)       # Save register $s1

    la $a0, msg_running    # Print running message
    li $v0, 4
    syscall

    li $t0, 0                  # Reset stop flag
    sw $t0, stop_clock
    li $s1, 120                # Set tick count

# CLOCK LOOP
clock_loop:
    lw $t0, stop_clock    # Load stop flag

    bnez $t0, clock_done    # If stop flag != 0 exit loop
    beqz $s1, clock_done    # If tick count = 0 exit
    
    jal delayOneSecond    # Call delay function
    jal incrementTime     # Increment clock time
    jal displayTime       # Display current time
    jal checkAlarm        # Check alarm

    addi $s1, $s1, -1    # Decrease tick count

    j clock_loop    # Repeat loop

# CLOCK END
clock_done:
    lw $s1, 0($sp)    # Restore $s1
    lw $ra, 4($sp)    # Restore return address

    addi $sp, $sp, 8    # Restore stack

    jr $ra    # Return

# FUNCTION: delayOneSecond
delayOneSecond:
    lw $t0, DELAY_COUNT    # Load delay count

delay_loop:
    beqz $t0, delay_done    # If counter = 0 finish
    addi $t0, $t0, -1    # Counter--

    j delay_loop    # Continue loop

delay_done:
    jr $ra    # Return

# FUNCTION: incrementTime
incrementTime:
    lw $t0, curr_seconds          # Load current seconds
    addi $t0, $t0, 1              # seconds++
    li $t1, 60                    # Load 60
    blt $t0, $t1, save_seconds    # If seconds < 60 save seconds

    li $t0, 0    # Reset seconds
    sw $t0, curr_seconds
    

    lw $t0, curr_minutes          # Load minutes
    addi $t0, $t0, 1              # minutes++
    blt $t0, $t1, save_minutes    # If minutes < 60 save

    li $t0, 0    # Reset minutes
    sw $t0, curr_minutes
    

    lw $t0, curr_hours          # Load hours
    addi $t0, $t0, 1            # hours++
    li $t1, 24                  # Load 24
    blt $t0, $t1, save_hours    # If hours < 24 save
    
    li $t0, 0    # Reset hours

save_hours:
    sw $t0, curr_hours     # Save hours
    jr $ra                 # Return

save_minutes:
    sw $t0, curr_minutes     # Save minutes
    jr $ra                   # Return

save_seconds:
    sw $t0, curr_seconds     # Save seconds
    jr $ra                   # Return

# FUNCTION: displayTime
displayTime:
    addi $sp, $sp, -4    # Allocate stack memory
    sw $ra, 0($sp)       # Save return address

    la $a0, msg_time_label    # Print "Time"
    li $v0, 4
    syscall

    lw $t0, curr_hours     # Load hours
    jal printTwoDigit     # Print hours

    la $a0, msg_colon    # Print 
    li $v0, 4
    syscall
    
    lw $t0, curr_minutes    # Load minutes
    jal printTwoDigit       # Print minutes

    la $a0, msg_colon    # Print 
    li $v0, 4
    syscall

    lw $t0, curr_seconds    # Load seconds
    jal printTwoDigit      # Print seconds

    la $a0, msg_led_label    # Print LED label
    li $v0, 4
    syscall

    lw $t0, led_state    # Load LED state
    beqz $t0, led_off    # If LED OFF go to led_off

    la $a0, msg_led_on    # Print ON
    li $v0, 4
    syscall

    j display_done

led_off:
    la $a0, msg_led_off    # Print OFF
    li $v0, 4
    syscall

display_done:
    lw $ra, 0($sp)        # Restore return address
    addi $sp, $sp, 4      # Restore stack
    jr $ra                # Return

# FUNCTION: printTwoDigit
printTwoDigit:
    addi $sp, $sp, -8               # Allocate stack memory
    sw $ra, 4($sp)                  # Save return address
    sw $t0, 0($sp)                  # Save value
    li $t1, 10                      # Load 10
    bge $t0, $t1, print_number      # If value >= 10 skip leading zero

    la $a0, msg_zero    # Print leading zero
    li $v0, 4
    syscall

print_number:
    lw $t0, 0($sp)    # Restore number
    move $a0, $t0    # Move number to $a0
    
    li $v0, 1    # Syscall 1 = print integer
    syscall      # Print number

    lw $ra, 4($sp)      # Restore return address
    addi $sp, $sp, 8    # Restore stack

    jr $ra    # Return

# FUNCTION: checkAlarm
checkAlarm:
    lw $t0, alarm_enabled    # Load alarm enabled flag
    beqz $t0, alarm_done     # If alarm disabled return

# CHECK HOURS
    lw $t1, curr_hours
    lw $t2, alarm_hours

    bne $t1, $t2, alarm_done

# CHECK MINUTES
    lw $t1, curr_minutes
    lw $t2, alarm_minutes

    bne $t1, $t2, alarm_done

# CHECK SECONDS
    lw $t1, curr_seconds
    lw $t2, alarm_seconds

    bne $t1, $t2, alarm_done

# ALARM ACTIVATED
    la $a0, msg_alarm_ring    # Print alarm message
    li $v0, 4
    syscall

    li $t0, 1    # Turn LED ON
    sw $t0, led_state

    la $a0, msg_snooze    # Ask user for snooze
    li $v0, 4
    syscall

    li $v0, 5    # Read user choice
    syscall

    li $t1, 1    # If choice != 1 dismiss alarm
    bne $v0, $t1, dismiss_alarm

# SNOOZE MODE
    la $a0, msg_snoozed    # Print snooze message
    li $v0, 4
    syscall

    lw $t0, alarm_minutes        # Load alarm minutes
    addi $t0, $t0, 5             # Add 5 minutes
    li $t1, 60                   # Load 60
    blt $t0, $t1, save_snooze    # If minutes < 60 save
    addi $t0, $t0, -60           # Subtract 60

    lw $t2, alarm_hours              # Load alarm hours
    addi $t2, $t2, 1                 # hours++
    li $t3, 24                       # Load 24
    blt $t2, $t3, save_alarm_hour    # If hours < 24 save
    li $t2, 0                        # Reset hours

save_alarm_hour:
    sw $t2, alarm_hours     # Save alarm hours

save_snooze:
    sw $t0, alarm_minutes    # Save alarm minutes

    li $t0, 0    # Turn LED OFF
    sw $t0, led_state
    j alarm_done

# DISMISS ALARM
dismiss_alarm:
    li $t0, 0    # Disable alarm
    sw $t0, alarm_enabled

    li $t0, 0    # Turn LED OFF
    sw $t0, led_state

    la $a0, msg_led_off    # Print LED OFF
    li $v0, 4
    syscall

    li $t0, 1    # Stop clock loop
    sw $t0, stop_clock

alarm_done:
    jr $ra     # Return