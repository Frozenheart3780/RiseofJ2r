import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kingsler.riseofj2r.data.local.Instruction1

@Dao
interface Dao1 {
    @Query("SELECT * FROM instructions")
    suspend fun getAllInstructions(): List<Instruction1>

    @Query("SELECT * FROM instructions WHERE category = :category")
    suspend fun getInstructionsByCategory(category: String): List<Instruction1>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(instruction: Instruction1)

    @Delete
    suspend fun delete(instruction: Instruction1)
    fun getByCategory(string: String): List<Instruction1>
}
