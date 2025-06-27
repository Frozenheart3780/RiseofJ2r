import androidx.room.Database
import androidx.room.RoomDatabase
import com.kingsler.riseofj2r.data.local.Instruction1

@Database(entities = [Instruction1::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dao1(): Dao1
}
