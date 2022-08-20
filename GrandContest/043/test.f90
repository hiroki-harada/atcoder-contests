program internal_file
  implicit none
  character(20) a
  integer :: i = 123
  write (a,*) i
  write (*,*) a
  write (*,*) i

end program internal_file