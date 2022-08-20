program test_a
implicit none

    character, allocatable, dimension(:, :):: s
    integer:: H, W
    integer:: cnt, i, j

    ! 要素数の割り当て
    read(*,*) H, W
    allocate(s(H, W))

    ! 行列の読み取り
    do j = 1, W
        do i = 1, H
            read(*,*) s(i, j)
        enddo
    enddo

    ! 操作回数を数える
    cnt = 0
    if (s(1, 1) == "#") cnt = cnt + 1
    if (s(H, W) == "#") cnt = cnt + 1

    do j = 2, W -1
        do i = 2, H - 1
           if ( s(i, j - 1) == "#" ) then
                if ( s(i - 1, j) == "#" ) then
                    cnt = cnt + 1
                endif

           endif
        enddo
    enddo






    ! 操作回数の出力
    write(*,*) cnt
    print *, "finished"

    include
    
stop
end program test_a