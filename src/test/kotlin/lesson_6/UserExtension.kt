package lesson_6

val UserEnum.user: User
  get() = User(
    fid = fid,
    login = login,
    fullName = fullName,
    email = email,
    phone = phone
  )
