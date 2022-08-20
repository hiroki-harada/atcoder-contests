program test_b
implicit none
    integer, allocatable, dimension(:, :):: x
    integer:: num, N, i, j

    read(*, *) N, num
    allocate(x(N, N))
    x = 0

    call to_array(num, N, x)

    ! x(1, N) を算出
    ! 要素が一つの場合
    if( N == 1) write(*,*) x(1, 1)

    do j = 1, N - 1
        do i = 1, N - j
            x(i, j + 1) = abs(x(i, j) - x(i + 1, j))
        enddo
    enddo

    write(*,*) x(1, N)
!print*, "finished"


contains
subroutine to_array(num, N, x)
    integer:: num, N, i
    character(len = N) num_string
    integer, dimension(N, N):: x

    print*, num, N
    write(num_string, "('(i',N,')')") num

    do i = 1, N
       read(num_string(i:i),*) x(i, 1)
    enddo

return
end subroutine to_array


end program test_b